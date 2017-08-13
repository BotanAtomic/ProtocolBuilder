package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildCharacsUpgradeRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5706;
    private boolean _isInitialized = false;
    private int charaTypeTarget = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.charaTypeTarget);
    }

    public void deserialize(ICustomDataInput param1) {
         this.charaTypeTarget = param1.readByte();
         if(this.charaTypeTarget < 0)
         {
            throw new Exception("Forbidden value (" + this.charaTypeTarget + ") on element of GuildCharacsUpgradeRequestMessage.charaTypeTarget.");
         }
    }

}