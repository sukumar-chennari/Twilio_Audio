var exec = require('cordova/exec');

exports.coolMethod = function (arg0,arg1,arg2,arg3 ,success, error) {
    exec(success, error, 'TwilioAudio', 'coolMethod', [arg0,arg1,arg2,arg3]);
};
