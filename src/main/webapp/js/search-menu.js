function hideForms() {
    $(document).find("form").find("div").css("display", "none");
}

function clearSelect() {
    $(document).find("form").find("span").attr("class", "");
}

$(document).ready(function () {
    var form = $(document).find("form");
    var choices = form.find("span");

    hideForms();

    choices.on("click", function () {
        hideForms();
        clearSelect();
        $(this).attr("class", "selected");
        var id = $(this).text();
        form.find("#" + id).css("display", "block");
    })
});