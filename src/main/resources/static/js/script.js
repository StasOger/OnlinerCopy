console.log("Hi");

$(document).on("change", "#???", function() {
   var selectedRegion = $(this).val();
   console.log("selected brand: ", selectedRegion);

   $("#???").find("option").each(function() {
      if ($(this).attr('???') == selectedRegion) {
         $(this).show();
      } else {
         $(this).hide();
      }
   });
});