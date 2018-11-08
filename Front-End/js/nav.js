function openNav(){
    document.getElementById("sideNav").style.width = "30%";
    document.getElementById("container").style.paddingRight = "30%";
    document.getElementById("container").style.width = "70%";
    document.getElementById("open-sideNav").style.paddingRight = "30%";
}
function closeNav()
{
    document.getElementById("sideNav").style.display = "0";
    document.getElementById("container").style.paddingRight = "0%";
    document.getElementById("container").style.width = "100%";
    document.getElementById("open-sideNav").style.paddingRight = "0%";
}