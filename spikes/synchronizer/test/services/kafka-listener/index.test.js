'use strict';

const assert = require('assert');
const app = require('../../../src/app');

describe('kafka-listener service', function() {
  it('registered the kafka-listeners service', () => {
    assert.ok(app.service('kafka-listeners'));
  });
});
