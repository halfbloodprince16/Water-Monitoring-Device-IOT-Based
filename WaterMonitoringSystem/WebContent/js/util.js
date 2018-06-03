function createXHR() {
	var xhrObj;
    if (!!window.XMLHttpRequest) { 
    	try {
    		xhrObj = new XMLHttpRequest();
    	} catch (e) {
    		xhrObj = null;
    	}
    } else if (!!window.createRequest) { 
        try {
        	xhrObj = window.createRequest();
        } catch (e) {
        	xhrObj = null;
        }
    } else if (!!window.ActiveXObject) {
    	try {
    		xhrObj = new ActiveXObject("Msxml2.XMLHTTP");
    	} catch(e) {
    		try {
    			xhrObj = new ActiveXObject("Microsoft.XMLHTTP");
    		}
    		catch(e) {
    			xhrObj = null;
    		}
    	}
    } else {
    	xhrObj = null;
    	console.log("createXHR failed due to unrecognized browser.");
    }
    return xhrObj;
}

function xhrGet(url, callback, errback) {
	var xhr = createXHR();
	xhr.open("GET", url, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				callback(parseJson(xhr.responseText));
			} else if (xhr.status == 204) {
				callback();
			} else {
				errback("Error: " + xhr.responseText, xhr.status);
			}
		}
	};
	xhr.timeout = 120000;
	xhr.ontimeout = errback;
	xhr.send();
}



function xhrPost(url, data, callback, errback) {
	var xhr = createXHR();
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				callback(parseJson(xhr.responseText));
			} else if (xhr.status == 204) {
				callback();
			} else {
				errback("Error: " + xhr.responseText, xhr.status);
			}
		}
	};
	xhr.timeout = 120000;
	xhr.ontimeout = errback;
	xhr.send(objectToQuery(data));
}

function parseJson(str) {
	var ret;
	try {
		ret = (!!window.JSON) ? JSON.parse(str) : eval("(" + str + ")");
	} catch (e) {
		parseErr(str, e);
	}
	return ret;
}

function objectToQuery(map) {
	var pairs = [], enc = encodeURIComponent;
	for (var name in map) {
		var value = map[name];
		var assign = enc(name) + "=";
		if (Array.isArray(value)) {
			for (var i = 0, len = value.length; i < len; ++i) {
				pairs.push(assign + enc(value[i]));
			}
		} else {
			pairs.push(assign + enc(value));
		}
	}
	return pairs.join("&");
}

function parseErr(str, err) {
	if (str != null && str != undefined) {
		if (str.indexOf("URI") > 0) {
			alert("Your session has expired. Please login and try again.");
			window.location.reload(false);
		} 
	}
}
