// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Sat Mar 06 01:21:08 CET 2021

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUsuariosController UsuariosController = new controllers.ReverseUsuariosController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDescripcionController DescripcionController = new controllers.ReverseDescripcionController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseRecetasController RecetasController = new controllers.ReverseRecetasController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseIngredientesController IngredientesController = new controllers.ReverseIngredientesController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUsuariosController UsuariosController = new controllers.javascript.ReverseUsuariosController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDescripcionController DescripcionController = new controllers.javascript.ReverseDescripcionController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseRecetasController RecetasController = new controllers.javascript.ReverseRecetasController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseIngredientesController IngredientesController = new controllers.javascript.ReverseIngredientesController(RoutesPrefix.byNamePrefix());
  }

}
