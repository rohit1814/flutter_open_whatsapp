import 'dart:async';

import 'package:flutter/services.dart';

class FlutterOpenWhatsapp {
  String mobileNo = "7985533639";
  String msg = "Hello";

  static const MethodChannel _channel =
      const MethodChannel('flutter_open_whatsapp');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<Null> sendSingleMessage(mobileNo, msg) async{
    await _channel.invokeMethod('sendSingleMessage', {'mobileNo': mobileNo, 'message': msg});
  }
}
