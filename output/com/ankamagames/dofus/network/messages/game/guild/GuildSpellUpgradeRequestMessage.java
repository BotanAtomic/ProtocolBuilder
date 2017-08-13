package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildSpellUpgradeRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5699;
    private boolean _isInitialized = false;
    private int spellId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
         }
         param1.writeInt(this.spellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.spellId = param1.readInt();
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element of GuildSpellUpgradeRequestMessage.spellId.");
         }
    }

}