package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.inventory.preset.IdolsPreset;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdolsPresetUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6606;
    private boolean _isInitialized = false;
    private IdolsPreset idolsPreset;
    private FuncTree _idolsPresettree;


    public void serialize(ICustomDataOutput param1) {
         this.idolsPreset.serializeAs_IdolsPreset(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.idolsPreset = new IdolsPreset();
         this.idolsPreset.deserialize(param1);
    }

}