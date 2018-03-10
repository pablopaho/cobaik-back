package co.com.cobaik.bikes.accesories.json.objects

//reference --> https://www.spinlister.com/rides/27231-bike-mountain-medellin-antioquia
case class AddAccesories(bikeSize: Float, bikeWheel: Float, frontSuspension: Boolean,
                         backSuspension: Boolean, backLight: Boolean, frontLight: Boolean,
                         padLock: Boolean, frameTubing: String, components: String)
