#import "HasBluetoothLePlugin.h"

@interface HasBluetoothLePlugin : CDVPlugin
@end
@implementation HasBluetoothLePlugin

- (void)check:(CDVInvokedUrlCommand *)command
{
    NSDictionary* returnObj = [NSDictionary dictionaryWithObjectsAndKeys: @"true", @"status", nil];
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:returnObj];
    [pluginResult setKeepCallbackAsBool:true];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end