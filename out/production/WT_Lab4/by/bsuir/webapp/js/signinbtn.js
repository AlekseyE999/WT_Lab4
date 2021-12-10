
document.getElementById('form-btn').addEventListener("click", async (e) => {
    e.preventDefault();
    location.replace((await fetch('/action?type=signin', {
        method: 'POST',
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        body: 'email=' + document.getElementById('form-email').value +
            '&password=' + MD5(MD5(document.getElementById('form-password').value) + document.getElementById('form-salt').value) +
            '&salt=' + document.getElementById('form-salt').value
    })).url);
    return false;
});