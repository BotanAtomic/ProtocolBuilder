package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.idol.Idol;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightStartMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 712;
    private boolean _isInitialized = false;
    private Idol[] idols;
    private FuncTree _idolstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.idols.length);
         int _loc2_ = 0;
         while(_loc2_ < this.idols.length)
         {
            (this.idols[_loc2_] as Idol).serializeAs_Idol(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Idol _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new Idol();
            _loc4_.deserialize(param1);
            this.idols.push(_loc4_);
            _loc3_++;
         }
    }

}