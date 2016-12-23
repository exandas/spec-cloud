'use strict';
const redisAuthor = require('./redis-author');
const kafkaListener = require('./kafka-listener');
const authentication = require('./authentication');
const user = require('./user');

module.exports = function() {
  const app = this;


  app.configure(authentication);
  app.configure(user);
  app.configure(kafkaListener);
  app.configure(redisAuthor);
};
