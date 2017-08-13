package com.ankamagames.dofus.network.messages.game.context.roleplay.document;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ComicReadingBeginMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6536;
    private boolean _isInitialized = false;
    private int comicId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.comicId < 0)
         {
            throw new Exception("Forbidden value (" + this.comicId + ") on element comicId.");
         }
         param1.writeVarShort(this.comicId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.comicId = param1.readVarUhShort();
         if(this.comicId < 0)
         {
            throw new Exception("Forbidden value (" + this.comicId + ") on element of ComicReadingBeginMessage.comicId.");
         }
    }

}