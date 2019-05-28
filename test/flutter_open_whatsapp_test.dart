import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_open_whatsapp/flutter_open_whatsapp.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_open_whatsapp');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await FlutterOpenWhatsapp.platformVersion, '42');
  });
}
