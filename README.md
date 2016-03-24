# Cordova-RFID-Reader-Plugin
This is cordova project plugin for RFID reader with arete pop plug

*** Making the cutomize plugin:

1. create directory structure
2. write the plugin.xml file
3. invoke the java codes & jar libs in the android folder
4. write the js file, which is used for connecting fornt-end code and native functions.
5.write the invoke method inside your cordova project
ps:demo codes please refer cordova-plugin-rfidreader.docx


*** Using the cutomize plugin:

1.install the rfidreader plugin into your project
2.put the invoke method wherever you want. If the method is successfully called, the info will return through the "alert(message)"
	
	var success = function (message) {         
   	    alert(message);
	    //you can put your own code here
        }
        var failure = function () {
            alert("Error calling Plugin");
        }
        reader.scan("TEST", success, failure);
       
3. try and test the function
