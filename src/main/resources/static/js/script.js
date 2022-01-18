console.log("Hi");

$(document).on("change", "#select-1", function() {
   var selectedBrand = $(this).val();
   console.log("selected brand: ", selectedBrand);

   $("#select-2").find("option").each(function() {
      if ($(this).attr('value') == selectedBrand) {
         $(this).show();
      } else {
         $(this).hide();
      }
   });
});


$(document).on("change", "#select-2", function() {
   var selectedModel = $(this).val();
   console.log("selected model: ", selectedModel);
   if (selectedModel != "Model") {
   console.log("selected model: ", selectedModel);
   $("#select-3").find("option").each(function() {
         if ($(this).attr('value') == selectedModel) {
            $(this).show();
         } else {
            $(this).hide();
         }
      });
   }
});


(function() {

  'use strict';

  $('.input-file').each(function() {
    var $input = $(this),
        $label = $input.next('.js-labelFile'),
        labelVal = $label.html();

   $input.on('change', function(element) {
      var fileName = '';
      if (element.target.value) fileName = element.target.value.split('\\').pop();
      fileName ? $label.addClass('has-file').find('.js-fileName').html(fileName) : $label.removeClass('has-file').html(labelVal);
   });
  });

})();

