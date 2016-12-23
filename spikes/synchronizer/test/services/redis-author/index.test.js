'use strict';

const assert = require('assert');
const app = require('../../../src/app');

describe('redis-author service', function() {
  it('registered the redis-authors service', () => {
    assert.ok(app.service('redis-authors'));
  });
});
