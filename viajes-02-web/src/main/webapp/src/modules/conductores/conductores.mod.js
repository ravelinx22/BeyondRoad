(function (ng) {
var mod = ng.module("conductorModule", ['ui.router']);
        mod.constant("conductoresContext", "api/Conductores");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        var basePath = 'src/modules/conductores/';
                $urlRouterProvider.otherwise("/conductoresList");
                self = this;
                $stateProvider.state('conductores', {
                url: '/conductores',
                        abstract: true,
                        resolve: {
                        conductores: ['$http', 'conductoresContext', function ($http, conductoresContext) {
                        return $http.get(conductoresContext);
                        }]
                        },
                        views: {
                        'mainView': {
                        templateUrl: basePath + 'conductores.html',
                                controller: ['$scope', 'conductores', function ($scope, conductores) {
                                $scope.conductoresRecords = conductores.data;
                                }]
                        }
                        }
                }).state('conductoresList', {
        url: '/list',
                parent: 'conductores',
                views: {
                'listView': {
                templateUrl: basePath + 'conductores.list.html'
                }
                }
        }).state('conductorDetail', {
        url: '/{conductorId:int}/detail',
                parent: 'conductores',
                param: {
                conductorId: null
                },
                resolve: {
                currentConductor: ['$http', 'conductoresContext', '$stateParams', function ($http, conductoresContext, $params) {
                return $http.get(conductoresContext + '/' + $params.conductorId);
                }]
                },
                views: {
                'detailView': {
                templateUrl: basePath + 'conductores.detail.html',
                        controller: ['$scope', 'currentConductor', function ($scope, currentConductor) {
                        $scope.currentConductor = currentConductor.data;
                        }]
                }
                }
        }).state('conductoresDetailReview', {
        url: '/reviews',
                parent: 'conductorDetail',
                views: {
                'detail': {
                templateUrl: basePath + 'conductores.detail.reviews.html'
                }
                }
        }).state('conductoresDetailAutomoviles', {
        url: '/automoviles',
                parent: 'conductorDetail',
                views: {
                'detail': {
                templateUrl: basePath + 'conductores.detail.automoviles.html'
                }
                }
        }).state('conductoresAdd', {
        url: '/add',
                parent: 'conductorDetail',
                views: {
                'listView': {
                templateUrl: basePath + 'conductores.anadir.html'
                }
                }})
                .state('reviewsFormulario', {
                url: '/addReview',
                        parent: 'conductorDetail',
                        views: {
                        'detail':
                        {
                        templateUrl: basePath + 'reviews.formulario.html',
                        controller: ['$scope','$http', 'conductoresContext',
                             function ($scope, $http,conductoresContext) {
                                 
                                 $scope.agregarRev= function (){
                                 
                               var valor = document.getElementById('radio').value;
                               var comment = document.getElementById('comment').value;
                               var idCalificado=$scope.currentConductor.id;
                               var idCalificador=document.getElementById('comment').value;
                               var review = {
                                    calificacion: valor,
                                    coment: comment,
                                    idCalificado:idCalificado,
                                    idCalificador: idCalificador
                                };
                                
                                $http.post('api/usuarios/'+ $scope.currentConductor.id +'/reviews', review)
                            }
                        }]
                        }
                        }})
                .state('automovilesFormulario', {
                url: '/addAuto',
                        parent: 'conductorDetail',
                        views: {
                        'detail':
                        {
                        templateUrl: basePath + 'automoviles.formulario.html',
                        controller: ['$scope','$http', 'conductoresContext',
                             function ($scope, $http,conductoresContext) {
                                 
                                 $scope.agregar= function (){
                                 
                                var placa = document.getElementById('placa').value;
                                var color = document.getElementById('color').value;
                                var marca = document.getElementById('marca').value;
                                var modelo = document.getElementById('modelo').value;
                                var aseg = document.getElementById('aseguradora').value;
                                var numseg = document.getElementById('numseguro').value;
                                var cantasientos = document.getElementById('cantasientos').value;
                                var carrito = {
                                    marca: marca,
                                    modelo: modelo,
                                    cantAsientos:cantasientos ,
                                    color:color,
                                    compSeguros:aseg ,
                                    numSeguro: numseg,
                                    placa:placa,
                                    conductorDTO:{
                                        id: $scope.currentConductor.id
                                    }
                                };
                                
                                $http.post('api/automoviles', carrito)
                            }
                        }]
                        }
                        }});
        }
        ]);
        })(window.angular);



