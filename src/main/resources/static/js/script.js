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