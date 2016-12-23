'use strict';

const hooks = require('./hooks');
const kafka = require('kafka-node');
const HighLevelConsumer = kafka.HighLevelConsumer;
const kafkaClient = new kafka.Client('localhost:2181');


class Service {
  constructor(options) {
    this.options = options || {};
    this.consumer = new HighLevelConsumer(
      kafkaClient,
      [
        { topic: 'executions'}
      ],
      {
        groupId: 'executions-listeners'
      }
    );

    console.log('kafkaClient created');
    console.log(this.consumer);

    this.consumer.on('message', function(message) {
      console.log('Message received: ');
      console.log(message);
    });

    this.consumer.on('error', function(err){
      console.log(err);
    })

  }

  find(params) {
    return Promise.resolve([]);
  }

  get(id, params) {
    return Promise.resolve({
      id, text: `A new message with ID: ${id}!`
    });
  }

  create(data, params) {
    if(Array.isArray(data)) {
      return Promise.all(data.map(current => this.create(current)));
    }

    return Promise.resolve(data);
  }

  update(id, data, params) {
    return Promise.resolve(data);
  }

  patch(id, data, params) {
    return Promise.resolve(data);
  }

  remove(id, params) {
    return Promise.resolve({ id });
  }
}

module.exports = function(){
  const app = this;

  // Initialize our service with any options it requires
  app.use('/kafka-listeners', new Service());

  // Get our initialize service to that we can bind hooks
  const kafkaListenerService = app.service('/kafka-listeners');

  // Set up our before hooks
  kafkaListenerService.before(hooks.before);

  // Set up our after hooks
  kafkaListenerService.after(hooks.after);
};

module.exports.Service = Service;
