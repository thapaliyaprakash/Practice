let clk_button = document.querySelector("#clk");
let reset = document.querySelector("#reset");
let curr_count = document.querySelector("#curr-count");
let count = 0;

clk_button.addEventListener('click',function(){
    count++
    curr_count.textContent = count;
    
});

reset.addEventListener("click",function(){
    count = 0
    curr_count.textContent = count;
});

let Decre = document.querySelector("#Decre");
Decre.addEventListener("click",function(){
    if(count > 0){
    count--
    curr_count.textContent = count;
    }
});