package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.IdentifiedEntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameEntitiesDispositionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5696;
    private boolean _isInitialized = false;
    private IdentifiedEntityDispositionInformations[] dispositions;
    private FuncTree _dispositionstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.dispositions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.dispositions.length)
         {
            (this.dispositions[_loc2_] as IdentifiedEntityDispositionInformations).serializeAs_IdentifiedEntityDispositionInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         IdentifiedEntityDispositionInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new IdentifiedEntityDispositionInformations();
            _loc4_.deserialize(param1);
            this.dispositions.push(_loc4_);
            _loc3_++;
         }
    }

}