import heapq
# clase grafo la cual permite construir un mapa con nodos que
#representan ciudades, en este caso ciudades del estado de Sinaloa
#permitiendo añadir nuevos nodos o vertices y sus relaciones (aristas)
#La heuristica es en base a la distancia en linea recta entre ciudades obtenida en google maps
class Grafo:
    def __init__(self):
        self.vertices = {}

    def agregar_vertice(self, vertice):
        if vertice not in self.vertices:
            self.vertices[vertice] = {}

    def agregar_arista(self, origen, destino, peso):
        if origen in self.vertices and destino in self.vertices:
            self.vertices[origen][destino] = peso
            self.vertices[destino][origen] = peso  

    def obtener_peso(self, origen, destino):
        if origen in self.vertices and destino in self.vertices[origen]:
            return self.vertices[origen][destino]
        return float('inf')

def a_estrella(grafo, inicio, objetivo):
    if inicio not in grafo.vertices or objetivo not in grafo.vertices:
        return None

    cola_prioridad = []
    heapq.heappush(cola_prioridad, (0, inicio))
    padres = {}
    costos = {inicio: 0}
    #mientras haya elementos en la cola de prioridad
    while cola_prioridad:
        costo_actual, vertice_actual = heapq.heappop(cola_prioridad)
        #si se ha llegado al objetivo regresar una lista con  el camino
        if vertice_actual == objetivo:
            camino = []
            while vertice_actual in padres:
                camino.append(vertice_actual)
                vertice_actual = padres[vertice_actual]
            camino.append(inicio)
            return camino[::-1]
        
        #sacar los vecinos del nodo actual 
        for vecino in grafo.vertices[vertice_actual]:
            costo = costos[vertice_actual] + grafo.obtener_peso(vertice_actual, vecino)
            if vecino not in costos or costo < costos[vecino]:
                costos[vecino] = costo
                prioridad = costo + heuristica(vecino, objetivo) #heuristica
                heapq.heappush(cola_prioridad, (prioridad, vecino))
                padres[vecino] = vertice_actual #acomodar al nodo actual como padre del nodo vecino

    return None 

def heuristica(origen, destino):
    # Distancias aproximadas desde cada ciudad al destino (Mazatlan)
    distancias = {
        'Culiacan': 200,
        'Mazatlan': 0,
        'La Cruz': 103,
        'Cosala': 177,
        'Higueras':133
    }
    return distancias[origen]


grafo = Grafo()
grafo.agregar_vertice('Culiacan')
grafo.agregar_vertice('Mazatlan')
grafo.agregar_vertice('La Cruz')
grafo.agregar_vertice('Cosala')
grafo.agregar_vertice('Higueras')


grafo.agregar_arista('Culiacan', 'Cosala', 166)
grafo.agregar_arista('Culiacan', 'La Cruz', 126)
grafo.agregar_arista('Cosala', 'La Cruz', 75)
grafo.agregar_arista('Cosala', 'Mazatlan',166)
grafo.agregar_arista('Culiacan', 'Higueras',88)
grafo.agregar_arista('Higueras', 'Cosala',92)
grafo.agregar_arista('Higueras', 'La Cruz',57)


grafo.agregar_arista('La Cruz', 'Mazatlan', 99)


inicio = 'Culiacan'
objetivo = 'Mazatlan'
camino = a_estrella(grafo, inicio, objetivo)
if camino:
    print("El camino más corto desde", inicio, "hasta", objetivo, "es:", camino)
else:
    print("No se encontró un camino desde", inicio, "hasta", objetivo)