#import "FlutterOpenWhatsappPlugin.h"
#import <flutter_open_whatsapp/flutter_open_whatsapp-Swift.h>

@implementation FlutterOpenWhatsappPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterOpenWhatsappPlugin registerWithRegistrar:registrar];
}
@end
