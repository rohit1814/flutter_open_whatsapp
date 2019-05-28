package infozenplus.com.flutter_open_whatsapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.app.Activity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterOpenWhatsappPlugin */
public class FlutterOpenWhatsappPlugin implements MethodCallHandler {

  Activity context;
  MethodChannel methodChannel;

  /** Plugin registration. */

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_open_whatsapp");
    channel.setMethodCallHandler(new FlutterOpenWhatsappPlugin(registrar.activity(), channel));
  }

  public FlutterOpenWhatsappPlugin(Activity activity, MethodChannel methodChannel) {
    this.context = activity;
    this.methodChannel = methodChannel;
    this.methodChannel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if(call.method.equalsIgnoreCase("sendSingleMessage")) {

      PackageManager packageManager = context.getPackageManager();
      Intent i = new Intent(Intent.ACTION_VIEW);
      try {
        String mobileNo = call.argument("mobileNo");
        String message = call.argument("message");
        //https://wa.me/919167370647?text=Yes%20We'll%20do%20this%20in%20frag4%20inOCW
        String url = "https://wa.me/" + mobileNo.trim() + "?text=" + message.trim();
        i.setPackage("com.whatsapp");
        i.setData(Uri.parse(url));
        if (i.resolveActivity(packageManager) != null) {
          context.startActivity(i);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      result.notImplemented();
    }
  }
}
