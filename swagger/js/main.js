window.loadFile = function(fileName) {
    var url;

    if (fileName && fileName.indexOf('.') === -1) {
      $('#objectTypeSelector')
        .val(fileName)
        .trigger('chosen:updated');

      url = '/swagger/' + fileName + '.yaml';
    } else {
      url = fileName;
    }

    $('#spec').hide();

    window.swaggerUi = SwaggerUIBundle({
      url: url,
      dom_id: '#swagger-ui-container',
      supportedSubmitMethods: ['get', 'post', 'put', 'delete', 'patch'],

      onFailure: function() {
        console.log('Unable to Load SwaggerUI');
      },

      requestInterceptor: function(req) {
        if (req.method === "POST") {
            var val = window.getCookieVal("csrftoken");
            req.headers["X-CSRFToken"] = val;
        }
        return req;
      },

      docExpansion: 'list',
      validatorUrl: null,
      jsonEditor: false,
      apisSorter: 'alpha',
      defaultModelRendering: 'schema',
      showRequestHeaders: false,

      deepLinking: true,
      presets: [
        SwaggerUIBundle.presets.apis,
        SwaggerUIStandalonePreset
      ],
      plugins: [
        SwaggerUIBundle.plugins.DownloadUrl
      ],
      layout: "StandaloneLayout"
    });

    $('.topbar').remove();
    $('.scheme-container').remove();

    var a = $('<a />')
      .text(window.location.origin + url)
      .attr('href', url);

    $('#openedFileLabel').html(a);
    $('#spec').show();

  };

window.getCookieVal = function(key) {
    var cookies, cookie, val = null;

    if (document.cookie) {
        cookies = document.cookie.split(";");
    }

    for(var i = 0; i < cookies.length; i++) {
        cookie = cookies[i].trim().split("=");
        if (cookie[0] === key) {
            val = cookie[1];
        }
    }

    return val;
}

window.init = function() {
    var fileName = window.location.search.match(/([^&]+)/);

    if (fileName && fileName.length > 1) {
      fileName = decodeURIComponent(fileName[1].slice(1));
    } else {
      fileName = 'VirtualService'; //default yaml filename to be loaded
    }

    var $selectorNode = $('#objectTypeSelector');

    window.objectTypes.forEach(function (config) {
      var option = $('<option />')
        .text(config.name)
        .attr('value', config.value);
      $selectorNode.append(option);
    });

    $selectorNode.chosen();

    window.loadFile(fileName);
  };

$(window.init);
  