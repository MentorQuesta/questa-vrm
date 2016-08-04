
function replaceAttribute(url, uniqueId) {
	var d = document.getElementById(uniqueId+"-attributes-div");
	d.innerHTML = "<div class='spinner-right'>loading...</div>";
	new Ajax.Request(
		url+"/edit-attributes",
		{
			onComplete : function(x) {
				d.innerHTML = x.responseText;
				evalInnerHtmlScripts(x.responseText,function() {
					Behaviour.applySubtree(d);
				});
				layoutUpdateCallback.call();
			}
		}
	);
	return false;
}

