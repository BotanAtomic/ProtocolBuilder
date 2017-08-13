package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectoryListEntry;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6046;
    private boolean _isInitialized = false;
    private Vector<JobCrafterDirectoryListEntry> listEntries;
    private FuncTree _listEntriestree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6046;
    }

    public JobCrafterDirectoryListMessage initJobCrafterDirectoryListMessage(Vector<JobCrafterDirectoryListEntry> param1) {
         this.listEntries = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.listEntries = new Vector.<JobCrafterDirectoryListEntry>();
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
         this.serializeAs_JobCrafterDirectoryListMessage(param1);
    }

    public void serializeAs_JobCrafterDirectoryListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.listEntries.length);
         int _loc2_ = 0;
         while(_loc2_ < this.listEntries.length)
         {
            (this.listEntries[_loc2_] as JobCrafterDirectoryListEntry).serializeAs_JobCrafterDirectoryListEntry(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobCrafterDirectoryListMessage(param1);
    }

    public void deserializeAs_JobCrafterDirectoryListMessage(ICustomDataInput param1) {
         JobCrafterDirectoryListEntry _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new JobCrafterDirectoryListEntry();
            _loc4_.deserialize(param1);
            this.listEntries.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobCrafterDirectoryListMessage(param1);
    }

    public void deserializeAsyncAs_JobCrafterDirectoryListMessage(FuncTree param1) {
         this._listEntriestree = param1.addChild(this._listEntriestreeFunc);
    }

    private void _listEntriestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._listEntriestree.addChild(this._listEntriesFunc);
            _loc3_++;
         }
    }

    private void _listEntriesFunc(ICustomDataInput param1) {
         JobCrafterDirectoryListEntry _loc2_ = new JobCrafterDirectoryListEntry();
         _loc2_.deserialize(param1);
         this.listEntries.push(_loc2_);
    }

}