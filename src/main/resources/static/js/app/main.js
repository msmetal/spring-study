var main = {
		init : function () {
			var _this = this;
			$('#btn-save').on('click', function(){
				_this.save();
			});
		},
		save : function () {
			var data = {
					title: $('#title').val(),
					author: $('#author').val(),
					content: $('#content').val()
			};
			
			console.log(data);
			console.log(JSON.stringify(data));
			
			$.ajax({
				type: 'POST',
				url: '/posts',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data)
			})
			.always(function() {
				// remove loading image
			})
			.fail(function(error) {
				// handle request failures
				console.log(error);
				alert('실패 하였습니다.');
			})
			.done(function(data) {
				alert('글이 등록 되었습니다.\n게시글번호: ' + data);
				location.reload();
			});
		}
};

main.init();