function ClickBtn(){
    function handleClick(){
        alert("BUtton clicked");
    }
    return(
        <button onClick={handleClick}>Click me </button>
    )
}

export default ClickBtn;