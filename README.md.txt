# RappiApp

Las capas de la aplicación (por ejemplo capa de persistencia, vistas, red, negocio, etc) y qué clases pertenecen a cual. 

Persistencia: 
com.test.molina.rappiapp.data.model.db (clases que generan las tablas de ROOM)
com.test.molina.rappiapp.data.local.db
AppDatabase (RoomDatabase class)
AppDbHelper (Helper para interactuar con la Database)

com.test.molina.rappiapp.data.local.db.dao
MovieDao (ROOM Data Access Object - database interactions)

com.test.molina.rappiapp.data.AppDataManager (da acceso a DBHelper y a ApiHelper)

com.test.molina.rappiapp.data.remote (acceso a la API)

AppApiHelper (call a la api a traves de Rx2AndroidNetworking)

com.test.molina.rappiapp.data.model.api
PopularMovieResponse, TopRatedMovieResponse, UpcomingMovieResponse (Responses to the API endpoint)

com.test.molina.rappiapp.rx (ReactiveX)
AppSchedulerProvider (provide Schedulers)

com.test.molina.rappiapp.di.module
AppModule (set of Dependency Injection Providers Dagger2)

com.test.molina.rappiapp.di.component
AppComponen( Component will provide injected instances by using modules)

com.test.molina.rappiapp.di.builder
ActivityBuilder (We map all our activities here, with their modules, that provides the correspondent ViewModel)

com.test.molina.rappiapp.ui.base (UI base classes las activities ,fragments y viewModels van a extender de estas clases)
BaseActivity (realiza databinding y Injection)
BaseFragment(idem)
BaseViewModel( a traves de esta clase los ViewModels tienen acceso a DataManager y SchedulerProvider)

SplashActivity (carga iinicial de datos)

MainActivity (administra los fragments y el search)
PopularFragment (Muestra los listados de peliculas)

PopularViewModel (maneja la logica de los datos de peliculas)


1. En qué consiste el principio de responsabilidad única? Cuál es su propósito? 
SOLID
Son un conjunto de principios que, aplicados correctamente, te ayudarán a escribir software de calidad en cualquier lenguaje de programación orientada a objetos
Principio de Responsabilidad Única:
un objeto debe realizar una única cosa.
Clases testeables, que respeten la capa correpondiente a la Arquitectura
Si los metodos publicos de la clase pueden ser subdivididos y reagrupados en otras clases



2. Qué características tiene, según su opinión, un “buen” código o código limpio? 
  Respetar un patron de Arquitectura com MVVM (este es el caso)
  Quedan cosas mejorables, pero la falta de tiempo para esto y test unitarios no me permitieron hacerlo)











