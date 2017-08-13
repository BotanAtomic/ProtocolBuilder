package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectoryEntryPlayerInfo;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectoryEntryJobInfo;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryEntryMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6044;
    private boolean _isInitialized = false;
    private JobCrafterDirectoryEntryPlayerInfo playerInfo;
    private JobCrafterDirectoryEntryJobInfo[] jobInfoList;
    private EntityLook playerLook;
    private FuncTree _playerInfotree;
    private FuncTree _jobInfoListtree;
    private FuncTree _playerLooktree;


    public void serialize(ICustomDataOutput param1) {
         this.playerInfo.serializeAs_JobCrafterDirectoryEntryPlayerInfo(param1);
         param1.writeShort(this.jobInfoList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.jobInfoList.length)
         {
            (this.jobInfoList[_loc2_] as JobCrafterDirectoryEntryJobInfo).serializeAs_JobCrafterDirectoryEntryJobInfo(param1);
            _loc2_++;
         }
         this.playerLook.serializeAs_EntityLook(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         JobCrafterDirectoryEntryJobInfo _loc4_ = null;
         this.playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
         this.playerInfo.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new JobCrafterDirectoryEntryJobInfo();
            _loc4_.deserialize(param1);
            this.jobInfoList.push(_loc4_);
            _loc3_++;
         }
         this.playerLook = new EntityLook();
         this.playerLook.deserialize(param1);
    }

}