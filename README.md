# matemonkey4j
Implementation of the low level Matemonkey  API in Java

This library strives to provide a light weight low dependency library to query MateMonkey's API in a simple fashion from Java.

The only dependency is on Jackson in order to (de)serialize API requests and responses.

## Status
[![Build Status](https://travis-ci.org/MateMonkey/matemonkey4j.svg?branch=master)](https://travis-ci.org/MateMonkey/matemonkey4j)
[![Coverity Scan Build Status](https://scan.coverity.com/projects/6780/badge.svg)](https://scan.coverity.com/projects/matemonkey-matemonkey4j)
[![codecov.io](https://codecov.io/github/MateMonkey/matemonkey4j/coverage.svg?branch=master)](https://codecov.io/github/MateMonkey/matemonkey4j?branch=master)

## License
Short version: 3-clause BSD

Long version: [LICENSE](LICENSE)


## Maintainer
tuxbox (sniggle.me)

## Modules
### api
The API module provides representations of the JSON API request and responses as Java POJO.
Further the common query and query builders are included.

### async
The async module provides the actual API calls in a way that caters for concurrent environments.
In general there's one callable for each API method.

### robospice
Convenience module that wraps the async module in a Robospice wrapper for convenience on Android.
