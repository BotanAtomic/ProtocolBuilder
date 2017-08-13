package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildGetInformationsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5550;
    private boolean _isInitialized = false;
    private int infoType = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.infoType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.infoType = param1.readByte();
         if(this.infoType < 0)
         {
            throw new Exception("Forbidden value (" + this.infoType + ") on element of GuildGetInformationsMessage.infoType.");
         }
    }

}