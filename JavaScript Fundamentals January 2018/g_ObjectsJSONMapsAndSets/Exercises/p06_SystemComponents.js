function systemComponents(arr) {
    let data = new Map();

    for (let i = 0; i < arr.length; i++) {
        let [system, component, subcomponent] = arr[i].split(/ \| /);

        if (!data.has(system)) {
            data.set(system, new Map());
        }

        if (!data.get(system).has(component)) {
            data.get(system).set(component, [])
        }

        data.get(system).get(component).push(subcomponent);
    }

    let sortedSystem = Array.from(data.keys())
        .sort((s1, s2) => {
            let s1CompCount = Array.from(data.get(s1).keys()).length;
            let s2CompCount = Array.from(data.get(s2).keys()).length;

            if (s1CompCount === s2CompCount) {
                return s1.toLowerCase().localeCompare(s2.toLowerCase());
            } else {
                return s2CompCount - s1CompCount;
            }
        });

    for (let key of sortedSystem) {
        console.log(key);

        let sortedComponents = Array.from(data.get(key).keys())
            .sort((c1, c2) => {
                let subCompCount1 = data.get(key).get(c1).length;
                let subCompCount2 = data.get(key).get(c2).length;
                return subCompCount2 - subCompCount1;
            });

        for (let innerKey of sortedComponents) {
            console.log(`|||${innerKey}`);

            for (let sub of data.get(key).get(innerKey)) {
                console.log(`||||||${sub}`);
            }
        }
    }
}
systemComponents(['SULS | Main Site | Home Page', 'SULS | Main Site | Login Page', 'SULS | Side Site | Login Page'])