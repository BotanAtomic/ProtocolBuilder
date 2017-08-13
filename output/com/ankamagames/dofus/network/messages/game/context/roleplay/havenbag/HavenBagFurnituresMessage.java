package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.HavenBagFurnitureInformation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HavenBagFurnituresMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6634;
    private boolean _isInitialized = false;
    private HavenBagFurnitureInformation[] furnituresInfos;
    private FuncTree _furnituresInfostree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.furnituresInfos.length);
         int _loc2_ = 0;
         while(_loc2_ < this.furnituresInfos.length)
         {
            (this.furnituresInfos[_loc2_] as HavenBagFurnitureInformation).serializeAs_HavenBagFurnitureInformation(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         HavenBagFurnitureInformation _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new HavenBagFurnitureInformation();
            _loc4_.deserialize(param1);
            this.furnituresInfos.push(_loc4_);
            _loc3_++;
         }
    }

}