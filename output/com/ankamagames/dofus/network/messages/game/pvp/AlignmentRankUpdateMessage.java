package package com.ankamagames.dofus.network.messages.game.pvp;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AlignmentRankUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6058;
    private boolean _isInitialized = false;
    private int alignmentRank = 0;
    private boolean verbose = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6058;
    }

    public AlignmentRankUpdateMessage initAlignmentRankUpdateMessage(int param1,boolean  param2) {
         this.alignmentRank = param1;
         this.verbose = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.alignmentRank = 0;
         this.verbose = false;
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
         this.serializeAs_AlignmentRankUpdateMessage(param1);
    }

    public void serializeAs_AlignmentRankUpdateMessage(ICustomDataOutput param1) {
         if(this.alignmentRank < 0)
            throw new Exception("Forbidden value (" + this.alignmentRank + ") on element alignmentRank.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AlignmentRankUpdateMessage(param1);
    }

    public void deserializeAs_AlignmentRankUpdateMessage(ICustomDataInput param1) {
         this._alignmentRankFunc(param1);
         this._verboseFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AlignmentRankUpdateMessage(param1);
    }

    public void deserializeAsyncAs_AlignmentRankUpdateMessage(FuncTree param1) {
         param1.addChild(this._alignmentRankFunc);
         param1.addChild(this._verboseFunc);
    }

    private void _alignmentRankFunc(ICustomDataInput param1) {
         this.alignmentRank = param1.readByte();
         if(this.alignmentRank < 0)
            throw new Exception("Forbidden value (" + this.alignmentRank + ") on element of AlignmentRankUpdateMessage.alignmentRank.");
    }

    private void _verboseFunc(ICustomDataInput param1) {
         this.verbose = param1.readBoolean();
    }

}