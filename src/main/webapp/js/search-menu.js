function hideForms() {
    $(document).find("form").find("div").css("display", "none");
}

function clearSelect() {
    $(document).find("form").find("label").attr("class", "");
}

$(document).ready(function () {
    var form = $(document).find("form");
    var choices = form.find("label");

    hideForms();

    choices.on("click", function () {
        hideForms();
        clearSelect();
        $(this).attr("class", "selected");
        var id = $(this).find("input").val();
        form.find("#" + id).css("display", "block");
    })
});