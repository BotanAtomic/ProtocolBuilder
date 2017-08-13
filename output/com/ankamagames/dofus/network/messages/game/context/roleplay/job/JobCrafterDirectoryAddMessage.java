package package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectoryListEntry;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryAddMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5651;
    private boolean _isInitialized = false;
    private JobCrafterDirectoryListEntry listEntry = ;
    private FuncTree _listEntrytree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5651;
    }

    public JobCrafterDirectoryAddMessage initJobCrafterDirectoryAddMessage(JobCrafterDirectoryListEntry param1) {
         this.listEntry = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.listEntry = new JobCrafterDirectoryListEntry();
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
         this.serializeAs_JobCrafterDirectoryAddMessage(param1);
    }

    public void serializeAs_JobCrafterDirectoryAddMessage(ICustomDataOutput param1) {
         this.listEntry.serializeAs_JobCrafterDirectoryListEntry(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobCrafterDirectoryAddMessage(param1);
    }

    public void deserializeAs_JobCrafterDirectoryAddMessage(ICustomDataInput param1) {
         this.listEntry = new JobCrafterDirectoryListEntry();
         this.listEntry.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobCrafterDirectoryAddMessage(param1);
    }

    public void deserializeAsyncAs_JobCrafterDirectoryAddMessage(FuncTree param1) {
         this._listEntrytree = param1.addChild(this._listEntrytreeFunc);
    }

    private void _listEntrytreeFunc(ICustomDataInput param1) {
         this.listEntry = new JobCrafterDirectoryListEntry();
         this.listEntry.deserializeAsync(this._listEntrytree);
    }

}