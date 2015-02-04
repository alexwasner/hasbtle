var bluetoothleName = "HasBluetoothLePlugin";
var hasbluetoothle = {
  check: function(successCallback, errorCallback, params){
    cordova.exec(successCallback, errorCallback, bluetoothleName, "check", []);
  }
}
module.exports = hasbluetoothle;