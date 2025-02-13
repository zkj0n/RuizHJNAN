function addModuloField(moduloCount = 1) {
    moduloCount++;
    const modulosContainer = document.getElementById('modulosContainer');
    const newModuloField = document.createElement('div');
    newModuloField.className = 'form-floating mb-3 d-flex justify-content-between align-items-center';
    newModuloField.innerHTML = `
            <input type="text" class="form-control" id="denominacionModulo${moduloCount}" placeholder="denominacionModulo${moduloCount}" name="denominacion">
            <label for="denominacionModulo${moduloCount}">Denominación del Módulo</label>
            <button type="button" class="btn btn-close bg-danger" onclick="deleteModuloField(${moduloCount})"></button>
        `;
    modulosContainer.appendChild(newModuloField);
}
function deleteModuloField(moduloCount) {
    const modulosContainer = document.getElementById('modulosContainer');
    const moduloField = document.getElementById(`denominacionModulo${moduloCount}`);
    modulosContainer.removeChild(moduloField.parentElement);
}