
;(function($) {
		
	$.fn.livedemo = function(options) {
		
        var codeblock = $('<div class="code-block"></div>');
        var blockclose = $('<span class="block-close">x</span>');
		
		return this.each(function(){
		
			var livedemo = $(this);
			
			livedemo.on('click', '.btn-code', function(e){
				e.preventDefault();
				
                var btn = $(this);
				var block = $(this).parents('.demo-block');
				var codes = block.find('.demo-code').html();
								
				if( block.next().hasClass('code-block') )
                {
					block.next().stop().slideToggle();
				}
                else
                {
					livedemo.find('.btn-code').removeClass('filled');					
					livedemo.find('.code-block').stop().slideUp(function(){ $(this).remove() });
					
					var newblock = codeblock.clone();
					newblock.append( codes ).append( blockclose ).insertAfter( block ).slideDown();
				}
							
				$(this).toggleClass('filled');
				
			}).on('click', '.block-close', function(){
				$(this).parents('.code-block').stop().slideUp().prev('.demo-block').find('.btn-code').removeClass('filled');
			});
			
		});
        
	};
})(jQuery);