document.getElementById('form-btn').addEventListener("click", async (e) => {
    e.preventDefault();
    location.replace((await fetch('/action?type=signup', {
        method: 'POST',
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        body: 'login=' + document.getElementById('form-login').value +
            '&name=' + document.getElementById('form-name').value +
            '&password=' + MD5(document.getElementById('form-password').value)
    })).url);
    return false;
});