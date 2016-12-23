'use strict';

const service = require('feathers-memory');
const hooks = require('./hooks');
const redis = require('redis');

module.exports = function(){
  const app = this;

  let options = {
    paginate: {
      default: 5,
      max: 25
    }
  };

  this.client = redis.createClient(32772);
  this.client.set('application','synchronizer', redis.print);

  // Initialize our service with any options it requires
  app.use('/redis-authors', service(options));

  // Get our initialize service to that we can bind hooks
  const redisAuthorService = app.service('/redis-authors');

  // Set up our before hooks
  redisAuthorService.before(hooks.before);

  // Set up our after hooks
  redisAuthorService.after(hooks.after);
};
