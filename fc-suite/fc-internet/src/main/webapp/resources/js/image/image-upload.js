
$(document).ready(function(e) {
	/*
	 * $('#imageUploadForm').on('submit',(function(e) { e.preventDefault(); var
	 * formData = new FormData(this);
	 * 
	 * $.ajax({ type:'POST', url: $(this).attr('action'), data:formData,
	 * cache:false, contentType: false, processData: false,
	 * success:function(data){ console.log("success"); console.log(data); },
	 * error: function(data){ console.log("error"); console.log(data); } });
	 * }));
	 * 
	 * $("#ImageBrowse").on("change", function() {
	 * $("#imageUploadForm").submit(); });
	 */

	/*
	 * $('#ImageBrowse').on('change',function () { var filePath = $(this).val();
	 * console.log(filePath); });
	 */

	$('input[type=file]').change(function() {
		console.log(this.files[0].mozFullPath);
	});
});
