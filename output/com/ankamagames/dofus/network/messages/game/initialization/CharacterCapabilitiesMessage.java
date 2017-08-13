package com.ankamagames.dofus.network.messages.game.initialization;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterCapabilitiesMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6339;
    private boolean _isInitialized = false;
    private int guildEmblemSymbolCategories = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.guildEmblemSymbolCategories < 0)
         {
            throw new Exception("Forbidden value (" + this.guildEmblemSymbolCategories + ") on element guildEmblemSymbolCategories.");
         }
         param1.writeVarInt(this.guildEmblemSymbolCategories);
    }

    public void deserialize(ICustomDataInput param1) {
         this.guildEmblemSymbolCategories = param1.readVarUhInt();
         if(this.guildEmblemSymbolCategories < 0)
         {
            throw new Exception("Forbidden value (" + this.guildEmblemSymbolCategories + ") on element of CharacterCapabilitiesMessage.guildEmblemSymbolCategories.");
         }
    }

}