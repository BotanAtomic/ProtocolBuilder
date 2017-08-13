package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightNewRoundMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6239;
    private boolean _isInitialized = false;
    private int roundNumber = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6239;
    }

    public GameFightNewRoundMessage initGameFightNewRoundMessage(int param1) {
         this.roundNumber = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.roundNumber = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightNewRoundMessage(param1);
    }

    public void serializeAs_GameFightNewRoundMessage(ICustomDataOutput param1) {
         if(this.roundNumber < 0)
         {
            throw new Exception("Forbidden value (" + this.roundNumber + ") on element roundNumber.");
         }
         param1.writeVarInt(this.roundNumber);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightNewRoundMessage(param1);
    }

    public void deserializeAs_GameFightNewRoundMessage(ICustomDataInput param1) {
         this._roundNumberFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightNewRoundMessage(param1);
    }

    public void deserializeAsyncAs_GameFightNewRoundMessage(FuncTree param1) {
         param1.addChild(this._roundNumberFunc);
    }

    private void _roundNumberFunc(ICustomDataInput param1) {
         this.roundNumber = param1.readVarUhInt();
         if(this.roundNumber < 0)
         {
            throw new Exception("Forbidden value (" + this.roundNumber + ") on element of GameFightNewRoundMessage.roundNumber.");
         }
    }

}