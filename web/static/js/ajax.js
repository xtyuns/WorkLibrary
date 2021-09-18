function postData(url, data, successCallback) {
    const lyIndex = layer.load(1);

    $.ajax(url, {
        type: 'POST',
        data: data,
        complete() {
            layer.close(lyIndex)
        },
        success(res) {
            if (res.code === 200) {
                layer.msg(res.data, {icon: 1});
                typeof successCallback === 'function' && successCallback(res)
            } else {
                layer.msg(res.msg, {icon: 2, anim: 6});
            }
        },
        error(err) {
            layer.msg(`error(${err.status}): ${err.statusText}`, {icon: 2, anim: 6});
        }
    })
}

function getData(url, successCallback) {
    const lyIndex = layer.load(1, { shade: [0.6,'#fff'] });

    $.ajax(url, {
        type: 'GET',
        complete() {
            layer.close(lyIndex)
        },
        success(res) {
            layer.msg(res.data || res.msg);
            typeof successCallback === 'function' && res.code === 200 && successCallback(res)
        },
        error(err) {
            layer.msg(`error(${err.status}): ${err.statusText}`, {icon: 2, anim: 6});
        }
    })
}