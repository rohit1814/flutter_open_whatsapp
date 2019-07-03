# Flutter Open WhatsApp

      A Flutter plugin to open WhatsApp and send message to single number in Android and iOS without saving user's number.

## Installation

      To use the plugin, add 'flutter_open_whatsapp' as a dependency in your pubspec.yaml file.


## Plugin package link

[plug-in package](https://github.com/rohit1814/flutter_open_whatsapp)


## Usage

   
    import 'package:flutter_open_whatsapp/flutter_open_whatsapp.dart';
       
     void main() => runApp(MyApp());
       
        class MyApp extends StatefulWidget {
         @override
         _MyAppState createState() => _MyAppState();
     }
      
     class _MyAppState extends State<MyApp> {
   
     @override
     Widget build(BuildContext context) {
       return MaterialApp(
         home: Scaffold(
           appBar: AppBar(
             title: const Text('Plugin example app'),
           ),
           body: Center(
             child: MaterialButton(onPressed: (){
               FlutterOpenWhatsapp.sendSingleMessage("918179015345", "Hello");
             },
               child: Text('Running on: $_platformVersion\n'),
             )
           ),
         ),
       );
     }
   }
   
## Example

    Refer to the example directory of flutter app.


