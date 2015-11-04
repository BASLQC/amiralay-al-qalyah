class Fleet():
	def __init__(self, fleet_id):
		"""
			Default Fleet Constructor is used to just get the current fleet configuration from the server as is.
			
			* `fleet_id` (integer) - The ID of the fleet to access.
		"""
		self.fleet_id = fleet_id
		self.ships = self.sync()

	def __init__(self, fleet_id, ships):
		"""
			Custom Fleet Constructor syncs a new fleet list both client and server side.
			
			* `fleet_id` (integer) - The ID of the fleet to access.
			* `ships` (tuple) - A list of Ship objects to add to the fleet.
		"""
		self.fleet_id = fleet_id
		self.ships = ships
		self.commit(self.ships)



	# These two methods keep the fleet list in sync with the server.
	def commit(self):
		"""
			This internal method is used to commit all changes in `ships` with the server.
		"""
		kancolle.update_fleet(self.ships)
		
	def sync(self):
		"""
			This internal method is used to obtain the current ship configuration from the server.
		"""
		self.ships = kancolle.get_fleet()


	@property
	def all_ships(self):
		"""
			Accessor: Returns a list of all ships.
		"""
		return self.ships
		
	@all_ships.setter
	def all_ships(self, ships):
		"""
			Mutator: Sets the list of all ships.
		"""
		self.ships = ships


	@property
	def position(self, index):
		"""
			Accessor: Takes a fleet position ID and returns the Ship object in this position.
		"""
		return self.ships[index]
		
	@position.setter
	def position(self, index, ship):
		"""
			Mutator: takes a fleet position ID and Ship object, and sets it in the list of Ships.
		"""
		self.ships[index] = ship


	@property
	def flagship(self):
		"""
			Accessor: Returns the Ship object in the first position, which is defined as the Flagship.
		"""
		return self.ships[1]
		
	@flagship.setter
	def flagship(self, ship):
		"""
			Mutator: takes a Ship object, and sets it as the Flagship (first ship) in the list of Ships.
		"""
		self.ships[1] = ship